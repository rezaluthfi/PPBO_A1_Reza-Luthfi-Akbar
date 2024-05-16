public class Manager extends Pegawai{
    public Manager(String nama, String departemen, char jenisKelamin){
        super(nama, departemen, jenisKelamin);
    }
    @Override
    public int thr(){
        return 2 * super.getGaji();
    }

    @Override
    public String nipPegawai(){
        String nip = super.getNip();
        if (nip != null && nip.startsWith("M")) {
            return nip;
        } else if (getClass() == Manager.class) {
            return "M000" + super.getUrutanMasuk();
        }
        return "P000" + super.getUrutanMasuk();
    }

    @Override
    public void displayInfo(){
        System.out.println("===============================================");
        System.out.println("Jabatan : Manager");
        System.out.println("Nama : " + super.getNama());
        System.out.println("Departemen : " + super.getDepartemen());
        System.out.println("NIP : " + nipPegawai());
        System.out.println("Gaji : " + super.getGaji());
        System.out.println("Gaji : " + thr());
        System.out.println("Cuti : " + super.banyakCuti());
    }
}
