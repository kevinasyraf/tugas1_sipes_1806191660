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
@Table(name = "pesawat")
public class PesawatModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "maskapai", nullable = false)
    private String maskapai;

    @NotNull
    @Size(max = 13)
    @Column(name = "nomor_seri", nullable = false, unique = true)
    private String nomorSeri;

    @NotNull
    @Size(max = 255)
    @Column(name = "tempat_dibuat", nullable = false)
    private String tempatDibuat;

    @NotNull
    @Column(name = "tanggal_dibuat", nullable = false)
    private Date tanggalDibuat;

    @NotNull
    @Size(max = 255)
    @Column(name = "jenis_pesawat", nullable = false)
    private String jenisPesawat;

    @OneToMany(mappedBy = "pesawatModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PenerbanganModel> listPenerbangan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipe", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TipeModel tipeModel;

    private Long idTipeModel;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "pesawat_teknisi",
            joinColumns = @JoinColumn(name = "id_pesawat"),
            inverseJoinColumns = @JoinColumn(name = "id_teknisi")
    )
    private List<TeknisiModel> listTeknisi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaskapai() {
        return maskapai;
    }

    public void setMaskapai(String maskapai) {
        this.maskapai = maskapai;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public void setNomorSeri(String nomorSeri) {
        this.nomorSeri = nomorSeri;
    }

    public String getTempatDibuat() {
        return tempatDibuat;
    }

    public void setTempatDibuat(String tempatDibuat) {
        this.tempatDibuat = tempatDibuat;
    }

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public String getJenisPesawat() {
        return jenisPesawat;
    }

    public void setJenisPesawat(String jenisPesawat) {
        this.jenisPesawat = jenisPesawat;
    }

    public List<PenerbanganModel> getListPenerbangan() {
        return listPenerbangan;
    }

    public void setListPenerbangan(List<PenerbanganModel> listPenerbangan) {
        this.listPenerbangan = listPenerbangan;
    }

    public TipeModel getTipeModel() {
        return tipeModel;
    }

    public void setTipeModel(TipeModel tipeModel) {
        this.tipeModel = tipeModel;
    }

    public Long getIdTipeModel() {
        return idTipeModel;
    }

    public void setIdTipeModel(Long idTipeModel) {
        this.idTipeModel = idTipeModel;
    }

    public List<TeknisiModel> getListTeknisi() {
        return listTeknisi;
    }

    public void setListTeknisi(List<TeknisiModel> listTeknisi) {
        this.listTeknisi = listTeknisi;
    }
}
