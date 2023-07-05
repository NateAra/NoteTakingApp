import axios from "axios";
import React, { useEffect, useState } from "react";

type Note = {
  id: string;
  name: string;
};

export const Body = () => {
  const [noteList, setNoteList] = useState<Note[]>([]);

  useEffect(() => {
    const fetchAllNotes = async () => {
      try {
        const response = await axios.get("http://localhost:3000/api/notes");
        const data = response.data;
        setNoteList(data); 
      } catch (error) {
        console.error();
      }
    };

    fetchAllNotes();
  }, []);

  return <div>
        {noteList.map((note) => (
          <h5 key={note.id}>
            {note.name} 
          </h5>
        ))}

    </div>;
};
