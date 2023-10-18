import { Component } from '@angular/core';
import { Items } from 'src/app/model/items.model';
import { Order } from 'src/app/model/order.model';
import { ItemsService } from 'src/app/service/items.service';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  data?: Order[];
  items?: Items[];
  orderIdSelected: any; 

  constructor(private orderService: OrderService,
    private itemsService: ItemsService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.orderService.getAll().subscribe((res:any)=>{
      this.data = res
    })
  }

  showDetailOrder(orderId: any){
    this.orderIdSelected = orderId;
    this.itemsService.getAll(orderId).subscribe((res: any) =>{
      this.items = res
    })
  }
}
