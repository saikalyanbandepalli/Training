import React,{Children, useState} from "react";
import { Maincontext } from "./Maincontext";
//const Context = React.createContext();
function Context(){
const [task,settask]=useState([{task:1},{task:2},{task:3}]);

const deletetask=(id)=>{
    let arr=[];
for(let key of task.keys){
    if(key != id){
        //console.log(key);
       arr.push(task);
    }
}
settask(arr);
};

const addtask=(re)=>{
settask([...task,re]);
};
return(
    <Context.Provider value={{settask,deletetask,addtask}}>
        {Children}
    </Context.Provider>
)
    
}
export default Context;

