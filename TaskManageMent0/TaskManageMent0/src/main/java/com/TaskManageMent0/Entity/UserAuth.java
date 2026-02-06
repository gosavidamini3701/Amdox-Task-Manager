package com.TaskManageMent0.Entity;

import com.TaskManageMent0.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "userAuth")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserAuth {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id ;

    @Column( nullable =  false )
    private String userName ;

    @Column( unique = true  , nullable = false )
    private String userOfficialEmail ;

    @Column( nullable = false )
    private String password ;

    @Enumerated( EnumType.STRING )
    @Column( nullable = false )
    private Role role ;

    private String resetToken ;
    private LocalDateTime resetTokenExpire ;

    public void setResetTokenExpire(LocalDateTime resetTokenExpire) {
        this.resetTokenExpire = resetTokenExpire;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getResetTokenExpire() {
        return resetTokenExpire;
    }

    public String getResetToken() {
        return resetToken;
    }

}
