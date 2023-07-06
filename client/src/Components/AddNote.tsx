import { useState, ChangeEvent, FormEvent } from "react";
import axios from "axios";

interface AddNoteProps {
  onAdd: () => void;
}

function AddNote(props: AddNoteProps) {
  const [note, setNote] = useState({
    title: "",
    note: ""
  });

  function handleChange(event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) {
    const { name, value } = event.target;

    setNote(prevNote => {
      return {
        ...prevNote,
        [name]: value
      };
    });
  }

  function submitNote(event: FormEvent) {
    event.preventDefault();

    axios.post("http://localhost:3000/api/notes", note)
      .then(() => {
        props.onAdd();
        setNote({
          title: "",
          note: ""
        });
      })
      .catch(error => {
        console.error("Error creating note:", error);
      });
  }

  return (
    <div>
      <form>
        <input
          name="title"
          onChange={handleChange}
          value={note.title}
          placeholder="Title"
        />
        <textarea
          name="note"
          onChange={handleChange}
          value={note.note}
          placeholder="Note..."
          rows={3}
        />
        <button onClick={submitNote}>Add</button>
      </form>
    </div>
  );
}

export default AddNote;