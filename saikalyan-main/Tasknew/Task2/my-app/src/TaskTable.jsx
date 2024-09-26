import React, { useContext, useState } from 'react'
import { TaskContext } from './TaskContextComponent'
import TaskForm from './TaskForm';

function TaskTable() {
    const [displayForm,setDisplayForm] = useState(false);
    const {tasks,addTask,deleteTask} = useContext(TaskContext);

    const handleDisplayForm=()=>{
        setDisplayForm((prev)=> prev === false ? true : false);
    }

    return (
        <div>
            <button onClick={handleDisplayForm} className='btn btn-primary'>Add Task</button>
            {displayForm ? <TaskForm setDisplayForm={handleDisplayForm}/> : ""}
            <table className="table">
            <thead>
                <tr>
                <th scope="col">TaskId</th>
                <th scope="col">Task Name</th>
                <th scope="col">Task Description</th>
                <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
                {
                    tasks.map((task)=>{
                        return (
                            <tr key={task.taskId}>
                                <th scope="row">{task.taskId}</th>
                                <td>{task.taskName}</td>
                                <td>{task.taskDescription}</td>
                                <td><button onClick={()=>{deleteTask(task.taskId)}}>Delete</button></td>
                            </tr>
                        )
                    })
                }
            </tbody>
            </table>
        </div>
    )
}

export default TaskTable