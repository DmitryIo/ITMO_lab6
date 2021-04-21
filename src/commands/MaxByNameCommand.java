package commands;


import app.Application;
import app.StudyGroup;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class MaxByNameCommand extends AddCommand {
    private HashSet<Long> idList;
    private LinkedHashSet<StudyGroup> collection;

    public MaxByNameCommand(){ }

    @Override
    public String execute(Application application) {
        idList = application.getIdList();
        collection = application.getCollection();
        return "Элемент из коллекции с макисмальным именем: " + application.getMaxStudyGroup().toString();
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
        return "max_by_name : вывести любой объект из коллекции, значение поля name которого является максимальным";
    }

    @Override
    public String toString() {
        return "max_by_name";
    }

    @Override
    public boolean withArgument() {
        return false;
    }
}