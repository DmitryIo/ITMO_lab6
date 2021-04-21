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
public class remove_any_by_students_countCommand extends Command implements CommandWithInit{
    private LinkedHashSet<StudyGroup> collection;
    private HashSet<Long> idList;
    private Long count;

    public remove_any_by_students_countCommand() { }

    public void init(String argument, Scanner scanner) {
        if (!FieldsValidator.checkStringParseToLong(argument, "count - это целое число!!!"))
            throw new InputFormatException();
        count = Long.parseLong(argument);
    }

    /**
     * удаление элемента
     *
     */
    @Override
    public String execute(Application application) {
        collection = application.getCollection();
        try {
            collection.removeIf(studyGroup -> studyGroup.getStudentsCount().equals(count));
        } catch (IdNotFoundException e) {
            return e.getMessage();
        }
        return "Элементы с studentsCount =  "+count+" удалены из коллекции";
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
        return "remove_any_by_students_count count : удалить из коллекции один элемент, значение поля studentsCount которого эквивалентно заданному";
    }

    @Override
    public String toString() {
        return "remove_any_by_students_count";
    }

    @Override
    public boolean withArgument() {
        return true;
    }
}