package dsl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    public String name;
    public List<Dependency> dependencies = new ArrayList<>();
    public Map<String, Task> tasks = new HashMap<>();
}