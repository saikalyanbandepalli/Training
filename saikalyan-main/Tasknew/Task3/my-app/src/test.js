import Context from "./context";
function test(a,b,c){
    const {settask,deletetask,addtask} = React.useContext(Context);
    return (
    <input type="text" name="random">enter input</input>
    {settask({random})};
    );

}
export default test;