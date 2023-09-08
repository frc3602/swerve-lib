/*
 * Copyright (C) 2023 Team 3602 All rights reserved. This work is
 * licensed under the terms of the MIT license which can be found
 * in the root directory of this project.
 */

package com.team3602.swervelib.swerve

import com.team3602.swervelib.swerve.SwerveModule
import com.team3602.swervelib.controller.FeedforwardConstants

class SwerveDrive(moduleConstants: Array<SwerveModuleConstants>, feedforwardConstants: FeedforwardConstants) {
    private var swerveModules: Array<SwerveModule>

    init {
        swerveModules = Array<SwerveModule>(4) {
            SwerveModule(0, moduleConstants[0], feedforwardConstants),
            SwerveModule(1, moduleConstants[1], feedforwardConstants),
            SwerveModule(2, moduleConstants[2], feedforwardConstants),
            SwerveModule(3, moduleConstants[3], feedforwardConstants)
        }
    }
}
