import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
static TODOFRAME jFrame;
static TODO_LIST todoList;
    public static void main(String[] args) {
        todoList = new TODO_LIST();

        jFrame = new TODOFRAME(todoList);


    }
}