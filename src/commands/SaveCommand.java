package commands;

import app.Application;
import app.Collection;
import app.FileWorker;
import app.StudyGroup;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * команда записывает коллекцию в файл в формате xml
 */
public class SaveCommand extends Command {
    private Application application;

    public SaveCommand() {
    }

    /**
     * запись в файл
     */
    @Override
    public String execute(Application application) {
        this.application = application;
        Collection collectionClass = new Collection();
        collectionClass.set(getCollection());
        if (FileWorker.saveCollection(collectionClass, "INPUT_PATH", "input.xml")) return "Коллекция сохранена в файл";
        return "Проблемы с переменной окружения и файлом по умолчанию на сервере, коллекция не сохранена...";
    }

    @Override
    public LinkedHashSet<StudyGroup> getCollection() {
        return application.getCollection();
    }

    @Override
    public HashSet<Long> getIdList() {
        return application.getIdList();
    }

    @Override
    String getCommandInfo() {
        return "save : сохранит коллекцию в файл";
    }

    @Override
    public String toString() {
        return "save";
    }

    @Override
    public boolean withArgument() {
        return false;
    }
}