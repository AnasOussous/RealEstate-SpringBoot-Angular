import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-updatecategory',
  templateUrl: './updatecategory.component.html',
  styleUrls: ['./updatecategory.component.css']
})
export class UpdatecategoryComponent implements OnInit {

  Id!: number;
  category: Category = new Category();
  constructor(private categoryService: CategoryService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.Id = this.route.snapshot.params['id'];
    this.categoryService.getCategoryById(this.Id).subscribe(data =>{
      this.category = data;
    },error => console.log(error));
    
    }
   
    onSubmit(){
      this.categoryService.updateCategory(this.Id, this.category).subscribe(data =>{
        this.goToCategoryList();
      },
         error => console.log(error));
         
  
    }

    goToCategoryList(){
      this.router.navigate(['/category']);
  
    }

}
