import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Health, IHealth } from '../model/health.model';
import { HealthService } from './health.service';

@Component({
  selector: 'app-health',
  templateUrl: './health.component.html',
  styleUrls: ['./health.component.css']
})
export class HealthComponent implements OnInit {
  health : IHealth = new Health();

  constructor(protected healthService: HealthService,
    protected activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {

    this.activatedRoute.data.subscribe(({health}) =>{
      this.health = health;
    });
  }

  previousState(){
    window.history.back();
  }

}
