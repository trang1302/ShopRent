import { Component } from '@angular/core';
import { Order } from 'src/app/model/order.model';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  data?: Order[];

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.orderService.getAll().subscribe((res:any)=>{
      this.data = res
    })
  }
}
