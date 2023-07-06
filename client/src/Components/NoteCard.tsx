export const NoteCard = (props: any) => {
  return (
    <div className="note">
      <h1>{props.title}</h1>
      <p>{props.note}</p>
      <button
      className="note_editBtn"
        onClick={() =>
          props.onEdit({ id: props.id, title: props.title, note: props.note })
        }
      >
        Edit
      </button>
      <button className="note_deleteBtn" onClick={() => props.onDelete(props.id)}>Delete</button>
    </div>
  );
};
