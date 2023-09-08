/*
 * Copyright (C) 2023 Team 3602 All rights reserved. This work is
 * licensed under the terms of the MIT license which can be found
 * in the root directory of this project.
 */

package com.team3602.swervelib.swerve

import com.ctre.phoenix.sensors.WPI_CANCoder
import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import com.revrobotics.RelativeEncoder
import com.team3602.swervelib.controller.FeedforwardConstants
import com.team3602.swervelib.swerve.swerveconstants.*
import edu.wpi.first.math.controller.SimpleMotorFeedforward
import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.kinematics.SwerveModulePosition
import edu.wpi.first.math.kinematics.SwerveModuleState

class SwerveModule(
        moduleNumber: Int,
        moduleConstants: SwerveModuleConstants,
        feedforwardConstants: FeedforwardConstants
) {
    private var moduleNumber: Int
    private var angleOffset: Rotation2d
    private var lastAngle: Rotation2d
    private var angleMotor: CANSparkMax
    private var driveMotor: CANSparkMax
    private var driveEncoder: RelativeEncoder
    private var angleEncoder: WPI_CANCoder
    private var moduleConstants: SwerveModuleConstants
    private var feedforward: SimpleMotorFeedforward =
            SimpleMotorFeedforward(
                    feedforwardConstants.kS,
                    feedforwardConstants.kV,
                    feedforwardConstants.kA
            )

    init {
        this.moduleNumber = moduleNumber
        this.moduleConstants = moduleConstants
        this.angleOffset = moduleConstants.angleOffset

        // Angle encoder config
        angleEncoder = WPI_CANCoder(moduleConstants.cancoderID)
        configAngleEncoder()

        // Angle motor config
        angleMotor =
                CANSparkMax(moduleConstants.angleMotorID, CANSparkMaxLowLevel.MotorType.kBrushless)
        configAngleMotor()

        // Drive motor config
        driveMotor =
                CANSparkMax(moduleConstants.driveMotorID, CANSparkMaxLowLevel.MotorType.kBrushless)
        driveEncoder = driveMotor.getEncoder()
        configDriveMotor()

        this.lastAngle = Rotation2d() // TODO: Change
    }

    private fun configAngleEncoder() {}

    private fun configAngleMotor() {}

    private fun configDriveMotor() {
        driveEncoder.setPositionConversionFactor(
                (wheelDiameterMeters * Math.PI) / driveMotorGearRatio
        )
        driveEncoder.setVelocityConversionFactor(
                ((wheelDiameterMeters * Math.PI) / driveMotorGearRatio) / 60
        )
    }

    fun getState(): SwerveModuleState {
        return SwerveModuleState(driveEncoder.getVelocity(), Rotation2d()) // TODO: Write this
    }

    fun getPosition(): SwerveModulePosition {
        return SwerveModulePosition() // TODO: Write this
    }
}
