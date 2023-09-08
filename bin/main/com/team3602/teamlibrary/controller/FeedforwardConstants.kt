/*
 * Copyright (C) 2023 Team 3602 All rights reserved. This work is
 * licensed under the terms of the MIT license which can be found
 * in the root directory of this project.
 */

package com.team3602.teamlibrary.controller

final class FeedforwardConstants(kS: Double, kG: Double, kV: Double, kA: Double) {
    public var kS: Double
    public var kG: Double
    public var kV: Double
    public var kA: Double

    init {
        this.kS = kS
        this.kG = kG
        this.kV = kV
        this.kA = kA
    }
}
