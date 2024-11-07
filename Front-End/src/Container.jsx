export function Container({ navbar, footer, children }) {
  return (
    <div>
      <nav> {navbar} </nav>
      <main> {children} </main>
      <footer> {footer} </footer>
    </div>
  );
}
