import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";
import AddNote from "./Components/AddNote";
import { NoteCard } from "./Components/NoteCard";

function App() {
  const [notes, setNotes] = useState<
    { id: number; title: string; note: string }[]
  >([]);
  const [editedNote, setEditedNote] = useState<{
    id: number;
    title: string;
    note: string;
  } | null>(null);

  const fetchNotes = async () => {
    try {
      const response = await axios.get("http://localhost:3000/api/notes");
      setNotes(response.data);
      console.log(response.data);
    } catch (error) {
      console.error("Error fetching notes:", error);
    }
  };

  useEffect(() => {
    fetchNotes();
  }, []);

  const addNote = () => {
    fetchNotes();
  };

  const editNote = async () => {
    fetchNotes();
    setEditedNote(null);
  };

  const deleteNote = async (id: number) => {
    try {
      await axios.delete(`http://localhost:3000/api/notes/${id}`);
      fetchNotes();
    } catch (error) {
      console.error("Error deleting note", error);
    }
  };

  return (
    <div>
      <header>
        <h1>Notary</h1>
      </header>
      <AddNote onAdd={addNote} onEdit={editNote} editingNote={editedNote} />
      {notes.map((note) => (
        <NoteCard
          key={note.id}
          id={note.id}
          title={note.title}
          note={note.note}
          onDelete={deleteNote}
          onEdit={() => setEditedNote(note)}
        />
      ))}
    </div>
  );
}

export default App;
