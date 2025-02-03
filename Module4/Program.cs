using System;
using System.Collections.Generic;

class Program
{
    static List<Task> tasks = new List<Task>();
    static int nextId = 1;

    static void Main(string[] args)
    {
        while (true)
        {
            Console.WriteLine("\nTo-Do List Application");
            Console.WriteLine("1. Add a Task");
            Console.WriteLine("2. View Tasks");
            Console.WriteLine("3. Remove a Task");
            Console.WriteLine("4. Exit");
            Console.Write("Select an option: ");

            switch (Console.ReadLine())
            {
                case "1":
                    AddTask();
                    break;
                case "2":
                    ViewTasks();
                    break;
                case "3":
                    RemoveTask();
                    break;
                case "4":
                    Console.WriteLine("Exiting...");
                    return;
                default:
                    Console.WriteLine("Invalid option, please try again.");
                    break;
            }
        }
    }

    static void AddTask()
    {
        Console.Write("Enter task description: ");
        string description = Console.ReadLine().Trim();
        if (string.IsNullOrEmpty(description))
        {
            Console.WriteLine("Task description cannot be empty.");
            return;
        }
        tasks.Add(new Task(nextId++, description));
        Console.WriteLine("Task added successfully.");
    }

    static void ViewTasks()
    {
        if (tasks.Count == 0)
        {
            Console.WriteLine("No tasks to display.");
            return;
        }
        Console.WriteLine("\nTasks:");
        foreach (Task task in tasks)
        {
            Console.WriteLine($"{task.Id}: {task.Description} - Completed: {task.IsCompleted}");
        }
    }

    static void RemoveTask()
    {
        Console.Write("Enter the ID of the task to remove: ");
        if (int.TryParse(Console.ReadLine(), out int id))
        {
            Task taskToRemove = tasks.Find(t => t.Id == id);
            if (taskToRemove != null)
            {
                tasks.Remove(taskToRemove);
                Console.WriteLine("Task removed successfully.");
            }
            else
            {
                Console.WriteLine("Task not found.");
            }
        }
        else
        {
            Console.WriteLine("Invalid ID.");
        }
    }
}