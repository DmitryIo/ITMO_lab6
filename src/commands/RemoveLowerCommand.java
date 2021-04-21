package commands;

import app.Application;
import app.FieldsValidator;
import app.StudyGroup;
import exceptions.IdNotFoundException;
import exceptions.InputFormatException;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * команда удаляет элемент из коллекции по его id
 */
public class RemoveLowerCommand extends Command implements CommandWithInit{
    private LinkedHashSet<StudyGroup> collection;
    private HashSet<Long> idList;
    private Long id;

    public RemoveLowerCommand() { }

    public void init(String argument, Scanner scanner) {
        if (!FieldsValidator.checkStringParseToLong(argument, "id - это целое число!!!"))
            throw new InputFormatException();
        id = Long.parseLong(argument);
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
//            for (StudyGroup i : collection){
            collection.removeIf(studyGroup -> studyGroup.getId() < id);
//            }
//            collection.removeIf(studyGroup -> studyGroup.getId() == id);
        } catch (IdNotFoundException e) {
            return e.getMessage();
        }
        return "Все элементы с id меньшим чем "+id+" удалены из коллекции";
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
        return "remove_lower id : удалит все элементы из коллекции меньшие чем данный";
    }

    @Override
    public String toString() {
        return "remove_lower";
    }

    @Override
    public boolean withArgument() {
        return true;
    }
}