package commander.domain

import io.domain.IO

class Commander(
    val io: IO
) {

    fun command() {
        while(true) {
            val command = io.getCommand()
            if(command == 0) break
            val commandType = Command.getCommandType(command)
            commandType.doCommand()
        }

    }
}