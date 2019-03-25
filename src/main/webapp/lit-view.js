import { LitElement, html } from "./web_modules/lit-element.js";

class LitView extends LitElement {
  render() {
    return html`
      The lit view
    `;
  }
}

customElements.define("lit-view", LitView);
