import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent implements OnInit {

  category: Category = new Category;
  constructor(private categoryService: CategoryService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  saveUser(){
this.categoryService.createCategory(this.category).subscribe(data => {
  console.log(data);
  this.goToUserList();

},
  error => console.log(error));
}

  goToUserList(){
    this.router.navigate(['/category']);

  }

  onSubmit(){
    console.log(this.category);
    this.saveUser()
    this.goToUserList();
    window.location.reload();

  }

}
