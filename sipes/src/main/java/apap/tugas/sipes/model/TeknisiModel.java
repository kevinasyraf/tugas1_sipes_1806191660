package apap.tugas.sipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "teknisi")
public class TeknisiModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "nomor_telepon", nullable = false)
    private Long nomorTelepon;

    @ManyToMany(mappedBy = "listTeknisi")
    List<PesawatModel> listPesawat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(Long nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public List<PesawatModel> getListPesawat() {
        return listPesawat;
    }

    public void setListPesawat(List<PesawatModel> listPesawat) {
        this.listPesawat = listPesawat;
    }
}
