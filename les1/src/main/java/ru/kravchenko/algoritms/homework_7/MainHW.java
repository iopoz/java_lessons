package ru.kravchenko.algoritms.homework_7;

import java.util.Stack;

public class MainHW {
    public static void main(String[] args) {
        testBFS();
    }

    private static void testBFS() {
        Graph graph = new GraphImplementation(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Москва", "Калуга");

        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");

        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");

        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

//        graph.bfs("Москва");

        Stack<Vertex> stack = graph.getShortWayByBfs("Москва", "Воронеж");
        int size = stack.size();
        System.out.println("Кратчайший путь Москва - Воронеж:");
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
