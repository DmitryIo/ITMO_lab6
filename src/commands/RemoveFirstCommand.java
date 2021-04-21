package commands;

import app.Application;
import app.FieldsValidator;
import app.StudyGroup;
import exceptions.IdNotFoundException;
import exceptions.InputFormatException;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveFirstCommand extends Command implements CommandWithInit{
    private LinkedHashSet<StudyGroup> collection;
    private HashSet<Long> idList;
    private Long id;

    public RemoveFirstCommand() { }

    public void init(String argument, Scanner scanner) {
//        if (!FieldsValidator.checkStringParseToLong(argument, "id - это целое число!!!"))
//            throw new InputFormatException();
        id = Long.parseLong("1");
    }

    /**
     * удаление элемента
     *
     */
    @Override
    public String execute(Application application) {
        collection = application.getCollection();
        idList = application.getIdList();
        try {
//            if (!idList.remove(id))
//                throw new IdNotFoundException("Элемент не удален, т.к. элемента с таким id нет в коллекции!!!");
            id = idList.iterator().next();
            collection.removeIf(studyGroup -> studyGroup.getId() == id);
        } catch (IdNotFoundException e) {
            return e.getMessage();
        }
        return "Элемент с id "+id+" удалён из коллекции";
    }

    @Override
    public LinkedHashSet<StudyGroup> getCollection() {
        return collection;
    }

    @Override
    public HashSet<Long> getIdList() {
        return idList;
    }

    @Override
    String getCommandInfo() {
        return "remove_first : удалит первый элемент из коллекции";
    }

    @Override
    public String toString() {
        return "remove_first";
    }

    @Override
    public boolean withArgument() {
        return false;
    }
}
