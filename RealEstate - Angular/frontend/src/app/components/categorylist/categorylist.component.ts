import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-categorylist',
  templateUrl: './categorylist.component.html',
  styleUrls: ['./categorylist.component.css']
})
export class CategorylistComponent implements OnInit {
  p: number = 1;
  nom = '';


  categorys: Category[] = [];
pageSize = 0;
perPage = 5;
  constructor(private categoryService: CategoryService, private router: Router) { }

  
  ngOnInit(): void {

    this.getCategory();
  }

  private getCategory(){
    this.categoryService.getCategoryList().subscribe(data =>{
      this.categorys = data;
      this.pageSize = this.categorys.length;
    });
  }

  categoryDetails(id:number){
    this.router.navigate(['category', id]);

  }

  updateCategory(id: number){
    this.router.navigate(['category', id]);
  }
  
  deleteCategory (id: number){
    this.categoryService.deleteCategory(id).subscribe(data =>{
   console.log(data);
      this.getCategory();
    })
  }

  orderHeader: String = '';
  isDescOrder: boolean = true;

  sort(HeaderNom:String){
    this.isDescOrder = !this.isDescOrder;
    this.orderHeader = HeaderNom;
  }

  

}
