import { Component } from '@angular/core';


@Component({
  selector: 'app-category-selector',
  templateUrl: './category-selector.component.html',
  styleUrls: ['./category-selector.component.scss']
})
export class CategorySelectorComponent {

  selectCategory(category: string) {
    console.log('Categoria selecionada:', category);
    // Aqui você pode adicionar a lógica para enviar a categoria para o seu endpoint
  }

}
