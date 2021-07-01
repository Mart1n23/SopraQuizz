import { Role } from "./role";

export class Personne {
  constructor(
    private _id: number | any= null,
    private _nom: string='',
    private _prenom: string='',
    private _mail: string='',
    private _password: string='',
    private _role: Role = Role.ROLE_USER,
  ) {}


    /**
     * Getter id
     * @return {number }
     */
	public get id(): number  {
		return this._id;
	}

    /**
     * Getter nom
     * @return {string}
     */
	public get nom(): string {
		return this._nom;
	}

    /**
     * Getter prenom
     * @return {string}
     */
	public get prenom(): string {
		return this._prenom;
	}

    /**
     * Getter mail
     * @return {string}
     */
	public get mail(): string {
		return this._mail;
	}

    /**
     * Getter password
     * @return {string}
     */
	public get password(): string {
		return this._password;
	}

    /**
     * Getter role
     * @return {Role }
     */
	public get role(): Role  {
		return this._role;
	}

    /**
     * Setter id
     * @param {number } value
     */
	public set id(value: number ) {
		this._id = value;
	}

    /**
     * Setter nom
     * @param {string} value
     */
	public set nom(value: string) {
		this._nom = value;
	}

    /**
     * Setter prenom
     * @param {string} value
     */
	public set prenom(value: string) {
		this._prenom = value;
	}

    /**
     * Setter mail
     * @param {string} value
     */
	public set mail(value: string) {
		this._mail = value;
	}

    /**
     * Setter password
     * @param {string} value
     */
	public set password(value: string) {
		this._password = value;
	}

    /**
     * Setter role
     * @param {Role } value
     */
	public set role(value: Role ) {
		this._role = value;
	}

}
