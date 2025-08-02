import React from 'react'

class CountPeople extends React.Component{
    constructor(){
        super();
        this.state={
            entryCount:0,
            exitCount:0,
        }
    }
    UpdateEntry=()=>{
        this.setState((prev)=>(
            {entryCount:prev.entryCount+1}
        ))
    }
     UpdateExit=()=>{
            this.setState((prev)=>(
            {exitCount:prev.exitCount+1}
        ))
    } 
    
  render() {

   return <div>
            <button onClick={this.UpdateEntry}>Login</button>
            <input type="text" value={this.state.entryCount}/>
            <button onClick={this.UpdateExit}>Logout</button>
            <input type="text" value={this.state.exitCount}/>
        </div>
  }
}

export default CountPeople
