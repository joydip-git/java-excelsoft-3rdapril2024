import Calculator from '../calculator/Calculator';
import Sample from '../sample/Sample';
//import { Calculator } from '../calculator/Calculator';
import './App.css';


function App() {
  return (
    <div className="App">
      <Calculator />
      <br /><br /><br />
      <Sample data={10} />
    </div>
  );
}

export default App;
