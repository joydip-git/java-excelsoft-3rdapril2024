import './App.css';
import ItemList from '../item-list/ItemList';
import Sample from '../sample/Sample';
import CalculatorWithHook from '../calculator-with-hook/CalculatorWithHook';

function App() {
  return (
    <div className="App">
      <ItemList />
      <br />
      <Sample />
      <br /><br />
      <CalculatorWithHook />
    </div>
  );
}

export default App;
