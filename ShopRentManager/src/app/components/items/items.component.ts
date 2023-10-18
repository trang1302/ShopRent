import { Component } from '@angular/core';
import { Items } from 'src/app/model/items.model';
import { ItemsService } from 'src/app/service/items.service';
@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent {
  data?: Items[];

  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.itemsService.getAll('').subscribe((res:any)=>{
      this.data = res
    })
  }
}
