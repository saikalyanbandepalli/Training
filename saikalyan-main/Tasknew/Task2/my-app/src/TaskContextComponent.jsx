import React, { createContext, useState } from 'react'
const TaskContext = createContext();

function TaskContextComponent({children}) {
  const [tasks,setTasks] = useState([
          { taskId: 1, taskName: "Task 1", taskDescription: "Description for Task 1" },
          { taskId: 2, taskName: "Task 2", taskDescription: "Description for Task 2" },
          { taskId: 3, taskName: "Task 3", taskDescription: "Description for Task 3" },
          { taskId: 4, taskName: "Task 4", taskDescription: "Description for Task 4" },
          { taskId: 5, taskName: "Task 5", taskDescription: "Description for Task 5" },
          { taskId: 6, taskName: "Task 6", taskDescription: "Description for Task 6" },
          { taskId: 7, taskName: "Task 7", taskDescription: "Description for Task 7" },
          { taskId: 8, taskName: "Task 8", taskDescription: "Description for Task 8" },
          { taskId: 9, taskName: "Task 9", taskDescription: "Description for Task 9" },
          { taskId: 10, taskName: "Task 10", taskDescription: "Description for Task 10" }
  ]);
   
  const addTask = (data)=>{
    let new_tasks=[...tasks,data];
    setTasks(new_tasks);
  }

  const deleteTask = (id)=>{
      let rem_tasks = tasks.filter(task=>{
          return task.taskId != id
      })

      setTasks(rem_tasks);
  }

  return (
      <TaskContext.Provider value={{tasks,addTask,deleteTask}}>
          {children}
      </TaskContext.Provider>
  )
}

export {TaskContext,TaskContextComponent};