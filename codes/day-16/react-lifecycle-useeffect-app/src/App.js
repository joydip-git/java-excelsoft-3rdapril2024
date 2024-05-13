import { useState } from 'react';
import './App.css';
import Sample from './sample/Sample';

function App() {
  const [show, setShow] = useState(false)
  const [messageValue, setMessageValue] = useState("Welcome to Sample Props")

  const updateMessage = (newMessage) => {
    setMessageValue(newMessage)
  }

  return (
    <div className="App">
      <button type='button' onClick={
        () => {
          setShow(
            (oldShow) => !oldShow
          )
        }
      }>
        {show ? 'Hide' : 'Show'}
      </button>
      <br />
      <br />

      <div>
        <label htmlFor='txtMessage'>New Message:&nbsp;</label>
        <input type='text' value={messageValue} onChange={(e) => { updateMessage(e.target.value) }} />
      </div>
      <br />
      {show && <Sample message={messageValue} />}
    </div>
  );
}

export default App;
