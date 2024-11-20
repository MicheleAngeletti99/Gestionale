import { TitleXL } from "./TitleXL";

export function Input({
  text = "Inserisci Prodotto",
  placeholder,
  name,
  type = "text",
}) {
  return (
    <label>
      <TitleXL text={text} />
      <input
        className="px-1 rounded border border-black"
        placeholder={placeholder}
        name={name}
        type={type}
      />
    </label>
  );
}
