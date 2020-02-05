package com.example.listatareas1;

class ListEntry {
    int id;
    String task;
    String place;
    int importance;

    public ListEntry(int id, String task, String place, int importance) {
        this.id = id;
        this.task = task;
        this.place = place;
        this.importance = importance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "ListEntry{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", place='" + place + '\'' +
                ", importance=" + importance +
                '}';
    }
}