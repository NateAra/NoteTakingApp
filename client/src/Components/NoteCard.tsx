
export const NoteCard = (props: any) => {
  return (
    <div className='note'>
        <h1>{props.title}</h1>
        <p>{props.note}</p>
        <button onClick={() => props.onDelete(props.id)}>Delete</button>
    </div>
  )
}
