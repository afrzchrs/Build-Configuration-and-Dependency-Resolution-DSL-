package dsl.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public String name;
    public List<String> commands = new ArrayList<>();
    public List<String> subTasks = new ArrayList<>();
}