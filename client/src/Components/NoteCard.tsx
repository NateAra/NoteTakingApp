export const NoteCard = (props: any) => {
  return (
    <div className="note">
      <h1>{props.title}</h1>
      <p>{props.note}</p>
      <button
        onClick={() =>
          props.onEdit({ id: props.id, title: props.title, note: props.note })
        }
      >
        Edit
      </button>
      <button onClick={() => props.onDelete(props.id)}>Delete</button>
    </div>
  );
};
