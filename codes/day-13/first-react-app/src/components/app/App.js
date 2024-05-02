import { AppHeader } from "../app-header/AppHeader";
import { AppFooter } from "../app-footer/AppFooter";

export function App() {
  const headerMessage = 'Welcome to React JS'
  const show = () => {
    window.alert('parent show method')
  }
  const call = function () {
    window.alert('called')
  }

  const design = (
    <div className="App" id="mainDiv">
      <AppHeader message={headerMessage} showHandler={show} />
      <br />
      <br />
      <br />
      <button type="button" onClick={call}>Call</button>
      <br />
      <br />
      <AppFooter />
    </div>
  )

  return design
}