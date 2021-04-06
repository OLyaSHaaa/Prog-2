package commands;

import exceptions.NoSuchCommandException;

public interface CommandManager {
    void usedScriptAdd(String scriptName);
    boolean scriptIsUsed(String scriptName);
    void executeCommand(String command, String arg) throws NoSuchCommandException;
    void clearUsedScripts();
    void usedScriptRemove(String scriptName);
}
