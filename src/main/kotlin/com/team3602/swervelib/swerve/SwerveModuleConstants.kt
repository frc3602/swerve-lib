/*
 * Copyright (C) 2023 Team 3602 All rights reserved. This work is
 * licensed under the terms of the MIT license which can be found
 * in the root directory of this project.
 */

package com.team3602.swervelib.swerve

import edu.wpi.first.math.geometry.Rotation2d

final class SwerveModuleConstants(
        driveMotorID: Int,
        angleMotorID: Int,
        cancoderID: Int,
        angleOffset: Rotation2d
) {
    val driveMotorID: Int
    val angleMotorID: Int
    val cancoderID: Int
    val angleOffset: Rotation2d

    init {
        this.driveMotorID = driveMotorID
        this.angleMotorID = angleMotorID
        this.cancoderID = cancoderID
        this.angleOffset = angleOffset
    }
}
