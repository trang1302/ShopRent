import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Items } from 'src/app/model/items.model';
import { ItemsService } from 'src/app/service/items.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {
  title: string = "This is item page.";
  items: Items[] = [];

  constructor(
    private itemsService: ItemsService, 
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const orderId = params['orderId'];
      this.showDetailOrder(orderId);
    });
  }

  showDetailOrder(orderId: any): void {
    this.itemsService.getAll(orderId).subscribe((res: any) =>{
      this.items = res;
    });
  }
}