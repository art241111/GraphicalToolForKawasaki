package ru.art241111.graphicaltoolforkawasaki.repository

import kawasakiRobots.KawasakiRobot

class RepositoryForRobotApi {
    private val robot = KawasakiRobot(address = "192.168.31.1")

    init {
        robot.robotInfo
    }
    fun updateInfoAboutPosition() =
        robot.service.updateInfoAboutPosition()

    fun switchRobotOff(){
        robot.switchRobotOff()
    }
    fun turnOnTheMotors() =
        robot.service.turnOnTheMotors()

    fun resetErrors() =
        robot.service.resetErrors()

    fun moveByX(position: Int) =
        robot.moving.moveByX(position)

    fun moveByY(position: Int) =
        robot.moving.moveByY(position)

    fun moveByZ(position: Int) =
        robot.moving.moveByZ(position)

}