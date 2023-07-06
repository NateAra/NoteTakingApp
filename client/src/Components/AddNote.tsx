import { useState, useEffect, ChangeEvent, FormEvent } from "react";
import axios from "axios";

interface AddNoteProps {
  onAdd: (note: { title: string; note: string }) => void;
  onEdit: (id: number, updatedNote: { title: string; note: string }) => void;
  editingNote: { id: number; title: string; note: string } | null;
}

function AddNote(props: AddNoteProps) {
  const [note, setNote] = useState({
    title: "",
    note: "",
  });

  function handleChange(
    event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) {
    const { name, value } = event.target;

    setNote((prevNote) => {
      return {
        ...prevNote,
        [name]: value,
      };
    });
  }

  useEffect(() => {
    if (props.editingNote) {
      setNote(props.editingNote);
    } else {
      setNote({
        title: "",
        note: "",
      });
    }
  }, [props.editingNote]);

  const addNote = (event: FormEvent) => {
    event.preventDefault();

    axios
      .post("http://localhost:3000/api/notes", note)
      .then(() => {
        props.onAdd(note);
        setNote({
          title: "",
          note: "",
        });
      })
      .catch((error) => {
        console.error("Error creating note:", error);
      });
  };

  const editNote = (event: FormEvent) => {
    event.preventDefault();

    if (!props.editingNote) return;

    axios
      .put(`http://localhost:3000/api/notes/${props.editingNote.id}`, note)
      .then(() => {
        if (props.editingNote) {
          props.onEdit(props.editingNote.id, note);
        }
        setNote({
          title: "",
          note: "",
        });
      })
      .catch((error) => {
        console.error("Error updating note:", error);
      });
  };

  const submitNote = (event: FormEvent) => {
    event.preventDefault();

    if (props.editingNote) {
      editNote(event);
    } else {
      addNote(event);
    }
  };

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
