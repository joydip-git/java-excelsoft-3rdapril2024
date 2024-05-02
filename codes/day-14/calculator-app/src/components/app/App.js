//import Calculator from '../calculator/Calculator';
import Parent from '../parent/Parent';
//import Sample from '../sample/Sample';
import './App.css';


function App() {
  console.log('App (re)rendered')
  return (
    <div className="App">
      {/* 
      
      <Calculator />
      <br /><br />
      <Sample />       
      <br /><br />

      */}
      <Parent />
    </div>
  );
}

export default App;
