import { useState } from 'react'
import './App.css'
import AddNote from './Components/AddNote'

function App() {
  const [note, setNote] = useState<{title: string, note: string}[]>([])

  function addNote(newNote: {title: string, note: string}) {
    setNote(prevNote => {
      return [...prevNote, newNote];
    });
  }

  return (
    <div>
      <header>
        <h1>Notary</h1>
      </header>
      <AddNote onAdd={addNote}/>

    </div>
  )
}

export default App
