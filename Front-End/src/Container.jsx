export function Container({ navbar, footer, children }) {
  return (
    <div className="overflow-hidden">
      <nav> {navbar} </nav>
      <main className="absolute top-20 left-0 w-screen"> {children} </main>
      <footer> {footer} </footer>
    </div>
  );
}
