import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
//inserimento del testo lettera per lettera
  public typewriter_text: string = "Wellcome to Truksi App";
  public typewriter_display: string = "";
  public display_: boolean = false;
   typingCallback(that) {
    let total_length = that.typewriter_text.length;
    let current_length = that.typewriter_display.length;
    if (current_length < total_length) {
      that.typewriter_display += that.typewriter_text[current_length];
      setTimeout(that.typingCallback, 100, that);
    } else {
      that.typewriter_display = "";
      that.display_ = true;
    }
  }
//fine

  constructor(private service: UserService, private router: Router) {
    this.loginDTO = new LoginDTO();
   }

  ngOnInit() {
    this.typingCallback(this);
    const body = document.getElementsByTagName('body')[0];
    body.classList.add('bg-gradient-primary');
  }
  ngOnDestroy(){
    const body = document.getElementsByTagName('body')[0];
    body.classList.remove('bg-gradient-primary');

  }

  login(f: NgForm): void {
    console.log('test' + f.value.username + f.value.password);
    //this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((user) => {

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));
        console.log('local storage:' + localStorage );
        switch (user.usertype.toString()) {
          case 'ADMIN': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case 'USER': {
            this.router.navigate(['/user-dashboard']);
            break;
          }
          case 'PASSENGER':
            {
              this.router.navigate(['/passenger-dashboard']);
              break;
            }
          case 'DRIVER':
            {
              console.log("/driver-dashboard");
              this.router.navigate(['/driver-dashboard']);
              break;
            }
          default:
            this.router.navigate(['/login']);
        }
      }
    });
  }
}
